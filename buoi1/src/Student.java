class Student{

    //thuoc tinh attributes
    String name;
    int age;

    //ham tao constructor
    public  Student(){ //tao mac dinh
        name="Nguyen Tuan Dat";
        age=20;
    }

    public Student(String name,int age){
        this.name=name;
        this.age=age;
    }

    // phương thức methods
    void sleep(){
        System.out.println("sleeping...");
    }
    void eat(){
        System.out.println("eating...");
    }

}
