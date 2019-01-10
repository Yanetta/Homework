package cloningExceptionsReflection;

/**
 * @author Tetiana Pedchenko
 */
public enum Vitamins {
	A, B, B1, B2, B6, B12, C, D, K, P, E;
}

//    //сохраняем состояние кота Васьки в поток и закрываем его(поток)
//    ous.write
//        ous.close();
//    ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
//    ObjectInputStream ois = new ObjectInputStream(bais);
//    //создаём кота для опытов и инициализируем его состояние Васькиным
//    Cat cloneVaska = (Cat)ois.readObject();
//        System.out.println(vaska);
//        System.out.println(cloneVaska);
//        System.out.println("*********************************************");
//        cloneVaska.setColor("Black");
//    //Убеждаемся что у кота Васьки теперь есть клон, над которым можно ставить опыты без ущерба Василию
//        System.out.println(vaska);
//        System.out.println(cloneVaska);
//}
//                }