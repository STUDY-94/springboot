package com.spring.boot.springboot.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

//@ExtendWith(MockitoExtension.class)
public class MockTest {

    @Mock
    Animal animal;

    @Test
    public void mockObject() {
        /* Mock 객체 생성 방법 2가지 */
        /* 1 */ MockitoAnnotations.initMocks(this);
//      /* 2 */ Animal animal = mock(Animal.class);

        assertNotNull(animal);

    }

    @Test
    public void mockBasicStub() {
        /*
        stub : 만들어진 mock 객체의 메소드를 실행했을 때 어떤 리턴 값을 리턴할지 정의하는 것
        */
        Animal animal = mock(Animal.class);

        when(animal.getAge()).thenReturn(30);
        when(animal.getName()).thenReturn("뱁새");
        when(animal.getFly()).thenReturn(true);

        assertEquals(30, animal.getAge());
        assertTrue(animal.getName().equals("뱁새"));
        assertTrue(animal.getFly() == true);


        List<String> animalList = new ArrayList<>();
        animalList.add("개");
        animalList.add("고양이");
        animalList.add("너구리");

        when(animal.getAnimalList()).thenReturn(animalList);
        assertNotNull(animalList);
        assertEquals(animalList.size(), 3);
        assertEquals(animal.getAnimalList().get(1), "고양이");

    }

    @Test
    public void mockStubDoThrow() {
        /*
        Stubber Method - doThrow
         */
        MockitoAnnotations.initMocks(this);

        doThrow(new RuntimeException()).when(animal).setAge(eq(20)); //eq : 정확히, eq(20) : 정확히 20
//        animal.setAge(10);
//        animal.setAge(15);
//        animal.setAge(20); //RuntimeException

        assertThrows(RuntimeException.class, () -> animal.setAge(20));
    }

    @Test
    public void mockVerify() {
        /*
        verify : 해당 구문이 호출되었는지 체크
         */
        Animal animal = mock(Animal.class);
        animal.setName("뱁새");

        //n번 호출했는지 체크
        verify(animal, times(1)).setName(any(String.class)); //success
        //호출 안했는지 체크
        verify(animal, never()).getName(); //success
        verify(animal, never()).setName(eq("참새")); //success
        verify(animal, times(1)).setName(eq("뱁새")); //fail
        //최소한 1번이상 호출했는지 체크
        verify(animal, atLeastOnce()).setName(any(String.class)); //success
        //2번 이하 호출했는지 체크
        verify(animal, atMost(2)).setName(any(String.class)); //success
        //2번 이상 호출했는지 체크
        verify(animal, atLeast(1)).setName(any(String.class)); //fail
        //지정된 시간(millis)안으로 메소드를 호출했는지 체크
        verify(animal, timeout(100)).setName(any(String.class)); //success
        //지정된 시간(millis)안으로 1번 이상 메소드를 호출했는지 체크
        verify(animal, timeout(100).atLeast(1)).setName(any(String.class)); //success
    }

    @Test
    public void BDDMockito() {
        Animal animal = mock(Animal.class);

        when(animal.getAge()).thenReturn(30);
        when(animal.getName()).thenReturn("뱁새");
        when(animal.getFly()).thenReturn(true);

        //GIVEN
        // when -> given
        given(animal.getName()).willReturn("뱁새");

        //WHEN
        animal.getName();
        animal.getName();
        animal.getName();
        animal.getName();

        //THEN
        //verify -> then
//        then(animal).should(times(2)).getName(); //fail
        then(animal).should(times(4)).getName(); //success
    }
}
