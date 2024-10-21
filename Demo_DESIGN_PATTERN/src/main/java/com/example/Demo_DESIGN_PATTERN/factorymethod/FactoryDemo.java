package com.example.Demo_DESIGN_PATTERN.factorymethod;

public class FactoryDemo {

    public static void main(String[] args) {
        AnimalFactory animalFactory = new AnimalFactory();

        Animal dog = animalFactory.getAnimal("Dog");
        System.out.println("Dog sound: " + dog.makeSound());

        Animal cat = animalFactory.getAnimal("Cat");
        System.out.println("Cat sound: " + cat.makeSound());
    }
}
