package by.epam.basic_of_oop.task5b;

import by.epam.basic_of_oop.task5b.bean.Gift;
import by.epam.basic_of_oop.task5b.logic.GiftLogic;

/*
 * Задача 5.
 * Создать консольное приложение, удовлетворяющее следующим требованиям:
 * Корректно спроектируйте и реализуйте предметную область задачи.
 * Для создания объектов из иерархии классов продумайте возможность использования порождающих шаблонов проектирования.
 * Реализуйте проверку данных, вводимых пользователем, но не на стороне клиента.
 * для проверки корректности переданных данных можно применить регулярные выражения.
 * Меню выбора действия пользователем можно не реализовывать, используйте заглушку.
 * Особое условие: переопределите, где необходимо, методы toString(), equals() и hashCode().
 * 
 * Вариант B. Подарки. 
 * Реализовать приложение, позволяющее создавать подарки (объект, представляющий собой подарок). 
 * Составляющими целого подарка являются сладости и упаковка.
 */

public class Main {

	public static void main(String[] args) throws Exception {
		
		Gift gift = new Gift();
		GiftLogic giftLogic = new GiftLogic();

		gift = giftLogic.createdGift();
		System.out.println(gift.toString());
	}
}
