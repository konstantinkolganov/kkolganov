package ru.job4j.generalizations;

import java.util.List;
import java.util.ArrayList;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Класс ConvertListTest. Тест метода List<Integer> convert(List<int[]> list).
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 04.11.2017
* @version 2.0
*/

public class ConvertListTest {
/**
* Класс ConvertListTest.
*/
/**
* Конвертация List<int[]> в один List<Integer>.
*/
	@Test
	public void whenListWithFiveArrayIntConvertThenListWithTwentyElementInteger() {
		// Новый объект Convert
		ConvertList convertList = new ConvertList();
		// Создаем список массивов
		List<int[]> listOfIntArray = new ArrayList<int[]>();
		listOfIntArray.add(new int[]{0, 1});
		listOfIntArray.add(new int[]{2, 3, 4});
		listOfIntArray.add(new int[]{5, 6, 7, 8});
		listOfIntArray.add(new int[]{9, 10, 11, 12, 13});
		listOfIntArray.add(new int[]{14, 15, 16, 17, 18, 19, 20});
		// Конвертируем массив в один список Integer
		List<Integer> listOfInteger = convertList.convert(listOfIntArray);
		// Размер листа должен быть 21 элемент
		assertThat(listOfInteger.size(), is(21));
	}
}