// Component interface
interface Noodles {
    String getDescription();

    double getCost();
}

// Concrete Component
class SimpleNoodles implements Noodles {
    @Override
    public String getDescription() {
        return "Simple Noodles";
    }

    @Override
    public double getCost() {
        return 7.0;
    }
}

// Base Decorator
abstract class NoodlesDecorator implements Noodles {
    protected Noodles decoratedNoodles;

    public NoodlesDecorator(Noodles noodles) {
        this.decoratedNoodles = noodles;
    }

    public String getDescription() {
        return decoratedNoodles.getDescription();
    }

    public double getCost() {
        return decoratedNoodles.getCost();
    }
}

// Concrete Decorators
class SauceDecorator extends NoodlesDecorator {
    public SauceDecorator(Noodles noodles) {
        super(noodles);
    }

    public String getDescription() {
        return super.getDescription() + ", Sauce";
    }

    public double getCost() {
        return super.getCost() + 1.5;
    }
}

class DrinkDecorator extends NoodlesDecorator {
    public DrinkDecorator(Noodles noodles) {
        super(noodles);
    }

    public String getDescription() {
        return super.getDescription() + ", Drink";
    }

    public double getCost() {
        return super.getCost() + 0.5;
    }
}

public class DecoratorDemo {
    public static void main(String[] args) {
        Noodles noodles = new SimpleNoodles();
        System.out.println(noodles.getDescription() + " $" + noodles.getCost());

        noodles = new SauceDecorator(noodles);
        System.out.println(noodles.getDescription() + " $" + noodles.getCost());

        noodles = new DrinkDecorator(noodles);
        System.out.println(noodles.getDescription() + " $" + noodles.getCost());
    }
}