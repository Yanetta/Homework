package cloningExceptionsReflection;

import java.io.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 * @author Tetiana Pedchenko
 */
public class Fruit1 implements Serializable{

    private FruitType fruitType;
    private int dayToLive;
    private LocalDate deliveryDate;
    private int price;
    private List<Vitamins> vitamins;
    private String color;
    private String description;
    private int weight;

    public Fruit1(FruitType fruitType, int dayToLive, LocalDate deliveryDate, int price, List<Vitamins> vitamins) {
        this.fruitType = fruitType;
        this.dayToLive = dayToLive;
        this.deliveryDate = deliveryDate;
        this.price = price;
        this.vitamins = vitamins;
    }

    public FruitType getFruitType() {
        return fruitType;
    }

    public void setFruitType(FruitType fruitType) {
        this.fruitType = fruitType;
    }

    public int getDayToLive() {
        return dayToLive;
    }

    public void setDayToLive(int dayToLive) {
        this.dayToLive = dayToLive;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Vitamins> getVitamins() {
        return vitamins;
    }

    public void setVitamins(List<Vitamins> vitamins) {
        this.vitamins = vitamins;
    }

    public String getColor() {
        return color;
    }

    public String getDescription() {
        return description;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getFruitTypeAndPrice() {
        String s = fruitType + " " + price;
        return s;
    }

    public void setColor() throws MyException {
        System.out.println("Put color of fruit here");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try {
            s = reader.readLine();
            if (s.equals("green") || s.equals("yellow") || s.equals("red") || s.equals("orange")) {
                this.color = s;

            } else {
                throw new MyException();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void setDescription() throws FileNotFoundException {

        BufferedReader br = null;
        br = new BufferedReader(new FileReader("src\\main\\resources\\input.txt"));
        try {

            description = br.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public int divide() throws ArithmeticException {

        Scanner scan = new Scanner(System.in);
        int input = 0;
        int part = 0;
        System.out.println("Put number here");

        input = scan.nextInt();
        if (input == 0) {
            throw new ArithmeticException();
        } else {
            part = weight / input;
        }

        System.out.println(part);
        return part;
    }

    public void printVitamins() throws IndexOutOfBoundsException {
        Vitamins[] vitaminsArray = (Vitamins[]) this.vitamins.toArray();
        vitaminsArray[20] = Vitamins.C;
        System.out.println(vitaminsArray[20]);
    }


    @Override
    public String toString() {
        return "Fruit1 [fruitType=" + fruitType + ", dayToLive=" + dayToLive + ", deliveryDate=" + deliveryDate
                + ", price=" + price + ", vitamins=" + vitamins + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + dayToLive;
        result = prime * result + ((deliveryDate == null) ? 0 : deliveryDate.hashCode());
        result = prime * result + ((fruitType == null) ? 0 : fruitType.hashCode());
        result = prime * result + price;
        result = prime * result + ((vitamins == null) ? 0 : vitamins.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Fruit1 other = (Fruit1) obj;
        if (dayToLive != other.dayToLive)
            return false;
        if (deliveryDate == null) {
            if (other.deliveryDate != null)
                return false;
        } else if (!deliveryDate.equals(other.deliveryDate))
            return false;
        if (fruitType != other.fruitType)
            return false;
        if (price != other.price)
            return false;
        if (vitamins == null) {
            if (other.vitamins != null)
                return false;
        } else if (!vitamins.equals(other.vitamins))
            return false;
        return true;
    }
}
