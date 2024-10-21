package com.example.Demo_DESIGN_PATTERN.factorymethod;

public class AnimalFactory {

    public Animal getAnimal(String type) {
        if ("Dog".equals(type)) {
            return new Dog();
        } else if("Cat".equals(type)) {
            return new Cat();
        }
        throw new IllegalArgumentException("Không tồn tại đối tượng có type: " + type);
    }
}
