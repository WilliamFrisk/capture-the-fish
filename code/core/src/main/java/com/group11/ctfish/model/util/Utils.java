package com.group11.ctfish.model.util;

import com.badlogic.gdx.math.Rectangle;

public class Utils {


    public static boolean collides(Object2D object1, Object2D object2) {

        Rectangle rectangleObject1 = new Rectangle(object1.getX(), object1.getY(), object1.getWidth(), object1.getHeight());
        Rectangle rectangleObject2 = new Rectangle(object2.getX(), object2.getY(), object2.getWidth(), object2.getHeight());

        if (rectangleObject1.overlaps(rectangleObject2)) {
            return true;
        }
        else return false;
    }
}

