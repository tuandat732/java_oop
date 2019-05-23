/**
  có 4 loại key access modipier(điều chỉnh quyền truy cập):
 private:cùng file,
 protected:cùng file,cùng package,từ class con
 default:cùng file,cùng package
 public:cùng file,cùng package,từ class con,khác package
 */

//thu tu uu tien
//string
//double
//int
//char


public class Program {
//
////    public static void main(String[] args) {
////        String message = "hello";//mac dinh = null
////        int x=1; //byte,short,int,long| mac dinh= 0
////        double b=2; //float,double | //byte,short,int,long| mac dinh= 0
////        char c='x';
////        boolean bool=true; //macdinh:false
////
////        System.out.println(message);
////        System.out.println(x);
////        System.out.println(b);
////        System.out.println(b+c);
////        System.out.println(bool);
////        System.out.println(message + b);
////        System.out.println(b+message); }
//
//    public static double sum(double a, double b) {
//        return a + b;
//    }
//
//    public static void summ(double a, double b) {
//        System.out.println(a + b);
//    }
//
//    //ham giai pt bac 2
//    public static double[] equation2(double a, double b, double c) {
//        if (a == 0) {
//            if (b == 0) {
//                if (c == 0) return null;
//                else return null;
//            } else {
//                double[] result = {-b / c,-b/c};
//                return result;
//            }
//        } else {
//            double[] result = new double[2];
//            double delta = b * b - 4 * a * c;
//            if (delta == 0) {
//                result[0] = -b / (2 * a);
//                result[1] = -b / (2 * a);
//                return result;
//            } else if (delta > 0) {
//                result[0] = (-b - Math.sqrt(delta)) / (2 * a);
//                result[0] = (-b + Math.sqrt(delta)) / (2 * a);
//                return result;
//            } else return null;
//        }
//    }
//
//    public static void main(String[] args) {
//        System.out.println(sum(2,5));
//
//        double sum=sum(10,111);
//        System.out.println(sum);
//
//        summ(1,2);
//        //if else
//        int random = 11111;
//        if (random > 10000) {
//            System.out.println("number too larger");
//        } else if (random < 10)
//            System.out.println("number too small");
//        else System.out.println("this is number: " + random);
//        //switch
//        switch (random) {
//            case 11111: {
//                System.out.println("number is 11111");
//                break;
//            }
//            case 1: {
//                System.out.println("number is 1");
//            }
//        }
//
//        //khai bao mang
//        int[] array = {1, 1, 2, 7};
//        int[] array2 = new int[5];//{0,0,0,0,0}
//
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }
//
//        for (int i = 0; i < array2.length; i++) {
//            System.out.println(array2[i]);
//        }
//
//        int i = 0;
//        while (i < array.length) {
//            System.out.println(array[i]);
//            i++;
//        }
//
//        double[] result = equation2(0, 2, 3);
//        if (result == null)
//            System.out.println("can not resolve quation");
//        else
//            System.out.println("x1= " + result[0] + ",x2= " + result[1]);
//
//    }

    public static void main(String[] args){
        Student student1 = new Student();
        Student student2 = new Student("Le Thi Ngoc Tram",19);

        System.out.println(student1.name);
        student1.eat();
        System.out.println(student2.name);
        student2.sleep();
    }

}

