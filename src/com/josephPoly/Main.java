package com.josephPoly;

// example 2
class Car {
    private String name;
    private boolean engine;
    private int cylinders;
    private int wheels;

    public Car(String name, int cylinders) {
        this.name = name;
        this.cylinders = cylinders;
        this.wheels = 4;
        this.engine = true;
    }

    public String getName() {
        return name;
    }

    public boolean hasEngine() {
        return engine;
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getWheels() {
        return wheels;
    }

    public String startEngine() {
        return "The engine has been started.";
    }

    public String accelerate() {
        return "Car is accelerating.";
    }

    public String brake() {
        return "The car is braking";
    }
}

class Tuscon extends Car {
    public Tuscon() {
        super("Tuscon", 6);
    }
    @Override
    public String startEngine() {
        return "The Tuscon engine has been started.";
    }
    @Override
    public String accelerate() {
        return "The Tuscon is accelerating.";
    }
    @Override
    public String brake() {
        return "The Tuscon is braking";
    }
}

class Wrangler extends Car {
    public Wrangler() {
        super("Wrangler", 6);
    }
    @Override
    public String startEngine() {
        return "The Wrangler engine has been started.";
    }
    @Override
    public String accelerate() {
        return "The Wrangler is accelerating.";
    }
    @Override
    public String brake() {
        return "The Wrangler is braking";
    }
}

class Honda extends Car {
    public Honda() {
        super("Honda", 4);
    }
    @Override
    public String startEngine() {
        return "The Honda engine has been started.";
    }
    @Override
    public String accelerate() {
        return "The Honda is accelerating.";
    }
    @Override
    public String brake() {
        return "The Honda is braking";
    }
}







// example 1
class Movie {
    private String name;

    public Movie(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String plot() {
        return "No plot here.";
    }
}

class Jaws extends Movie {
    public Jaws() {
        super("Jaws");
    }

    public String plot() {
        return "A shark eats lots of people";
    }
}

class IndependenceDay extends Movie {
    public IndependenceDay() {
        super("Independence Day");
    }

    @Override
    public String plot() {
        return "Aliens attempt to takeover Earth";
    }
}

class MazeRunner extends Movie {
    public MazeRunner() {
        super("Maze Runner");
    }

    @Override
    public String plot() {
        return "Kids try to escape a maze";
    }
}

class Forgettable extends Movie {
    public Forgettable() {
        super("Forgettable");
    }
}

public class Main {

    public static void main(String[] args) {


        //testing Car base class
        Car car = new Car("Car", 6);
        System.out.println(car.accelerate());
        System.out.println(car.brake());
        System.out.println(car.startEngine());


        Wrangler wrangler = new Wrangler();
        System.out.println(wrangler.accelerate());

        System.out.println(wrangler.brake());

        System.out.println(wrangler.startEngine());

        for(int i = 1; i < 11; i++ ) {
            Movie movie = randomMovie();
            if (movie != null) {
                System.out.println("Movie #" + i + " : " + movie.getName() + "\n" +
                                    "Plot of movie : " + movie.plot() + "\n");
            }
        }

    }

    public static Movie randomMovie() {
        int randomNumber = (int) (Math.random() * 4);
        System.out.println("Random number generated was " + randomNumber);
        switch (randomNumber) {
            case 1:
                return new Jaws();
            case 2:
                return new IndependenceDay();
            case 3:
                return new MazeRunner();
            default:
                return new Forgettable();
        }
    }
}
