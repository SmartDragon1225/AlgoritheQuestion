package 剑职offer经典算笔试编程题.最小的k个数;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.locks.Lock;

public class MinKNumber {
    public static void main(String[] args) throws Exception {
        int arr[] = {3,4,2,1};
        System.out.println(Arrays.toString(minK(arr, 3)));
        Student student = new Student(1, "田智龙");
        Student student1 = student.clone();
        System.out.println(student);
        System.out.println(student1);
        System.out.println(student == student1);
        System.out.println(student.equals(student1));
        System.out.println(4.0-3.6);//因为计算机用二进制计算时出现了误差
        String str = "hello";
        Method m = str.getClass().getMethod("toUpperCase"); //通过反射获得
        System.out.println(m.invoke(str));
        System.out.println(str.toUpperCase());
        int a = 1;int b = 2;
        swap(a,b);
        System.out.println(a+" "+b);
        Map map = new HashMap();
        Set set = new HashSet();
    }

    /**
     * java采用值传递，形参的改变不引起实参的改变
     * @param a
     * @param b
     */
    public static void swap(Integer a,Integer b){
        Integer t = a;
        a = b;
        b = t;
    }
    public static int[] minK(int arr[],int k){
        Arrays.sort(arr);
        int a[] = new int[k];
        for(int i = 0;i < k;i++){
            a[i] = arr[i];
        }
        return a;
    }
}
class Student implements Cloneable{
    private int id;
    private String name;
    public Student(int id,String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    protected Student clone() throws CloneNotSupportedException {
        return (Student)super.clone();
    }

}