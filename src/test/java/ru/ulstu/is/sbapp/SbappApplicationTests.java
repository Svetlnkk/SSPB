package ru.ulstu.is.sbapp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ru.ulstu.is.sbapp.array.service.ArrayService;

@SpringBootTest
class SbappApplicationTests {
	@Autowired
	ArrayService arrayService;

	@Test
	void testArrayNorm(){
		final String res = arrayService.runArray(5, 5, "ArrayNorm");
        Assertions.assertEquals("Привет Мир!", res);
	}
	@Test
	void testArrayTrans(){
		final String res = arrayService.runArray(5, 5, "ArrayTrans");
        Assertions.assertEquals("Привет Мир!", res);
	}
	@Test
    void testArrayErrorWired() {
        Assertions.assertThrows(NoSuchBeanDefinitionException.class, () -> arrayService.runArray(5, 5, "ArrayNorm"));
    }

}
