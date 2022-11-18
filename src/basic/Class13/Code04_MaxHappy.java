package basic.Class13;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Code04_MaxHappy
 * @Author: 5753
 * @Date: 2022/10/10 8:53
 * @Description: TODO
 */
public class Code04_MaxHappy {
    public static class Info {
        int yes;
        int no;

        public Info(int yes, int no) {
            this.yes = yes;
            this.no = no;
        }
    }

    public static class Employee {
        public int happy;
        public List<Employee> nexts;

        public Employee(int h) {
            happy = h;
            nexts = new ArrayList<>();
        }

    }

    public static int maxHappy2(Employee head) {
        Info allInfo = process(head);
        return Math.max(allInfo.yes, allInfo.no);
    }

    public static Info process(Employee head) {
        if (head == null) return new Info(0, 0);
        int no = 0;
        int yes = head.happy;

        for (Employee next : head.nexts) {
            Info process = process(next);
            yes += process.no;
            no += Math.max(process.yes, process.no);
        }
        return new Info(yes,no);
    }


}
