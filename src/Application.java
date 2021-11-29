import java.text.NumberFormat;
import java.util.Date;

public class Application {
    public static void main(String[] args) {

        Shop1 shop1 = new Shop1();
        Shop2 shop2 = new Shop2();

        shop1.buyClothes();
        shop1.buyFood();
        shop1.buyMedicine();
        System.out.println("----------------------------------");
        Counter.checkAllSales();
        System.out.println("----------------------------------");
        shop2.buyClothes();
        shop2.buyClothes();
        System.out.println("----------------------------------");
        Counter.checkAllSales();

    }
}



abstract class Item{
    protected double price;

    protected double setMaxDigits(double price){
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);

        return Double.parseDouble(numberFormat.format(price));
    }

    abstract protected double calculatePrice();
}

class Food extends Item{

    Food(){
       price= calculatePrice();
    }

    @Override
    protected double calculatePrice() {
        double temp =1 + (int) (Math.random() * 100);
        return setMaxDigits(temp +(temp/100*5));
    }
}


class Medicine extends Item{

    Medicine(){
        price = calculatePrice();
    }

    @Override
    protected double calculatePrice() {
        double temp = 100 + (int) (Math.random() * 200);
        return setMaxDigits(temp +(temp/100*10));
    }
}

class Clothes extends Item{

    Clothes(){
        price = calculatePrice();
    }

    @Override
    protected double calculatePrice() {
        double temp = 1 + (int) (Math.random() * 200);
        return setMaxDigits(temp +(temp/100*15));
    }
}

class Counter{

    private static StringBuilder totallySell = new StringBuilder("Список всіх продаж\n");
    private  double totallyPrice=0;



    private Counter(){ }

    private static class CounterHolder{

        public static  final Counter Counter_Instance = new Counter();

    }

    public static Counter getInstance(){
        return CounterHolder.Counter_Instance;
    }

    public void smthSales(Item item){
        Date date = new Date();
        totallyPrice += item.price;
        String info = "Область продажі: "+item.getClass().getName()+" Ціна: "+item.price+"$ Дата: "+date+
                "\nСума продажу всіх предметів: "+totallyPrice+"$\n";
        totallySell.append(info);
        System.out.println(info);
    }

    public static void checkAllSales(){
        System.out.println(totallySell);
    }
}


class  Shop1{
    private Counter counter = Counter.getInstance();

    void buyFood(){
        System.out.println("Продажа в магазині 1");
        Food food = new Food();
        counter.smthSales(food);
    }

    void buyMedicine(){
        System.out.println("Продажа в магазині 1");
        Medicine medicine = new Medicine();
        counter.smthSales(medicine);
    }

    void buyClothes(){
        System.out.println("Продажа в магазині 1");
        Clothes clothes = new Clothes();
        counter.smthSales(clothes);
    }
}

class Shop2{
    private Counter counter = Counter.getInstance();

    void buyFood(){
        System.out.println("Продажа в магазині 1");
        Food food = new Food();
        counter.smthSales(food);
    }

    void buyMedicine(){
        System.out.println("Продажа в магазині 1");
        Medicine medicine = new Medicine();
        counter.smthSales(medicine);
    }

    void buyClothes(){
        System.out.println("Продажа в магазині 1");
        Clothes clothes = new Clothes();
        counter.smthSales(clothes);
    }
}

