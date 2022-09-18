package basic.Class07;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName: Code02_EveryStepShowBoss
 * @Author: 5753
 * @Date: 2022/9/10 9:41
 * @Description: TODO
 */
public class Code02_EveryStepShowBoss {

    public static class Customer {
        private Integer id;
        private Integer buy;
        private Integer enterTime;

        public Customer(Integer id, Integer buy, Integer enterTime) {
            this.id = id;
            this.buy = buy;
            this.enterTime = 0;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getBuy() {
            return buy;
        }

        public void setBuy(Integer buy) {
            this.buy = buy;
        }

        public Integer getEnterTime() {
            return enterTime;
        }

        public void setEnterTime(Integer enterTime) {
            this.enterTime = enterTime;
        }
    }

    public static class CompareCands implements Comparator<Customer> {
        //返回负数 o1在前面
        //返回正数 o2在前面
        //返回0 两个数相等
        @Override
        public int compare(Customer o1, Customer o2) {
            return Objects.equals(o1.buy, o2.buy) ? o1.enterTime - o2.enterTime : o2.buy - o1.buy;
        }
    }

    public static class CompareDaddys implements Comparator<Customer> {
        @Override
        public int compare(Customer o1, Customer o2) {
            return Objects.equals(o1.buy, o2.buy) ? o1.enterTime - o2.enterTime : o1.buy - o2.buy;
        }
    }

    public static class WhosYourDaddy {
        private Map<Integer, Customer> customers;
        private HeapGreater<Customer> candHeap;
        private HeapGreater<Customer> daddyHeap;

        private Integer daddyLimit;


        public WhosYourDaddy(Integer limit) {
            this.customers = new HashMap<>();
            this.candHeap = new HeapGreater<>(new CompareCands());
            this.daddyHeap = new HeapGreater<>(new CompareDaddys());
            this.daddyLimit = limit;
        }


//        处理事件
        public void operate(int time, Integer id, Boolean buyOrRefund) {
            if (!buyOrRefund && !customers.containsKey(id)) {
                return;
            }
            if (!customers.containsKey(id)) {
                customers.put(id, new Customer(id, 0, 0));
            }
            Customer customer = customers.get(id);

            if (buyOrRefund) {
                customer.buy++;
            } else {
                customer.buy--;
            }

            if (customer.buy < 1) {
                customers.remove(id);
            }

            if (!candHeap.contains(customer) && !daddyHeap.contains(customer)) {
                if (daddyHeap.size() < daddyLimit) {
                    customer.enterTime = time;
                    daddyHeap.push(customer);
                } else {
                    customer.enterTime = time;
                    candHeap.push(customer);
                }
            } else if (candHeap.contains(customer)) {
                if (customer.buy == 0) {
                    candHeap.remove(customer);
                } else {
                    candHeap.resign(customer);
                }
            } else {
                if (customer.buy == 0) {
                    daddyHeap.remove(customer);
                } else {
                    daddyHeap.resign(customer);
                }
            }

            //调整两个区的
            daddyMove(time);

        }


        private void daddyMove(int time) {
            if (candHeap.isEmpty()) {
                return;
            }

            if (daddyHeap.size() < this.daddyLimit) {
                Customer customer = candHeap.pop();
                customer.setEnterTime(time);
                daddyHeap.push(customer);
            } else {
                //获奖区满了
                Customer candTop = candHeap.peek();
                Customer daddyTop = daddyHeap.peek();
                if (candTop.buy > daddyTop.buy) {
                    Customer poll = candHeap.pop();
                    Customer poll1 = daddyHeap.pop();

                    candHeap.remove(poll);
                    daddyHeap.remove(poll1);

                    candHeap.push(poll1);
                    daddyHeap.push(poll);
                }
            }
        }

        private List<Integer> getTopKAns() {
            List<Customer> customers = daddyHeap.getAllElements();
            return customers.stream().map(Customer::getId).collect(Collectors.toList());
        }


    }

    public static List<List<Integer>> topK(int[] arr, boolean[] op, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        WhosYourDaddy daddy = new WhosYourDaddy(k);
        for (int i = 0; i < arr.length; i++) {
            int id = arr[i];
            boolean buyOrRefund = op[i];
            daddy.operate(i, id, buyOrRefund);
            ans.add(daddy.getTopKAns());
        }
        return ans;
    }


    /**
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @Author 5753
     * @Description 暴力直接的方法，没有任何的优化
     * @Date 11:36 2022/9/10
     * @Param [arr, op, k]
     **/
    public static List<List<Integer>> compare(int[] arr, boolean[] op, int k) {
        List<Customer> cands = new ArrayList<>();
        List<Customer> daddys = new ArrayList<>();
        Map<Integer, Customer> map = new HashMap<>();

        //返回结果，每个时间段所有的获奖名单
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            //顾客ID
            int id = arr[i];
            //当前事件的购买或者退款操作
            boolean buyOrRefund = op[i];

            //当顾客表没有这个顾客信息的时候并且他是退款操作

            if (!map.containsKey(id) && !buyOrRefund) {
                ans.add(getCurAns(daddys));
                continue;
            }

            if (!map.containsKey(id)) {
                //初始化该顾客的一个信息
                map.put(id, new Customer(id, 0, 0));
            }
            Customer customer = map.get(id);
            if (buyOrRefund) {
                customer.buy++;
            } else {
                customer.buy--;
            }

            //最终如果顾客的购买数量为0了，则直接删除该顾客
            if (customer.buy == 0) {
                map.remove(id);
            }

            //如果当前顾客既不存在获奖区也不存在候选区
            if (!daddys.contains(customer) && !cands.contains(customer)) {
                if (daddys.size() < k) {
                    //此时获奖区的人没有满
                    customer.enterTime = i;
                    daddys.add(customer);
                } else {
                    customer.enterTime = i;
                    cands.add(customer);
                }
            }

            //清除两个奖区为购买数为0的顾客
            cleanZeroBuy(cands);
            cleanZeroBuy(daddys);

            //在调整两个奖区之前对两个奖区中的顾客按照特定条件排序
            cands.sort(new CompareCands());
            daddys.sort(new CompareDaddys());


            //调用两个奖区
            move(cands, daddys, i, k);

            ans.add(getCurAns(daddys));
        }
        return ans;

    }

    private static void move(List<Customer> cands, List<Customer> daddys, int i, int k) {
        if (cands.isEmpty()) {
            return;
        }

        if (daddys.size() < k) {
            while (daddys.size() < k) {
                for (Customer cand : cands) {
                    cand.enterTime = i;
                    daddys.add(cand);
                    cands.remove(cand);
                }
            }
            return;
        } else {
            //获奖区满了
            Customer candsTop = cands.get(0);
            Customer daddysTop = daddys.get(0);
            if (candsTop.buy > daddysTop.buy) {
                cands.remove(candsTop);
                daddys.remove(daddysTop);
                candsTop.enterTime = i;
                daddysTop.enterTime = i;
                cands.add(daddysTop);
                daddys.add(candsTop);
            }
        }
    }


    private static void cleanZeroBuy(List<Customer> list) {
        for (Customer customer : list) {
            if (customer.buy == 0) {
                list.remove(customer);
            }
        }
    }

    private static List<Integer> getCurAns(List<Customer> daddys) {
        List<Integer> ans = new ArrayList<>();
        for (Customer daddy : daddys) {
            ans.add(daddy.id);
        }
        return ans;
    }

    public static class Data {
        public int[] arr;
        public boolean[] op;

        public Data(int[] a, boolean[] o) {
            arr = a;
            op = o;
        }
    }


    public static Data randomData(int maxValue, int maxLen) {
        int length = (int) (Math.random() * maxLen) + 1;
        int[] arr = new int[length];
        boolean[] op = new boolean[length];

        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * maxValue);
            op[i] = Math.random() < 0.5;
        }
        return new Data(arr, op);
    }


    public static void main(String[] args) {
        int maxValue = 10;
        int maxLen = 100;
        int maxK = 6;
        int testTimes = 100000;
        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++) {
            Data testData = randomData(maxValue, maxLen);
            int k = (int) (Math.random() * maxK) + 1;
            int[] arr = testData.arr;
            boolean[] op = testData.op;
            List<List<Integer>> ans1 = topK(arr, op, k);
            List<List<Integer>> ans2 = compare(arr, op, k);
            if (!sameAnswer(ans1, ans2)) {
                for (int j = 0; j < arr.length; j++) {
                    System.out.println(arr[j] + " , " + op[j]);
                }
                System.out.println(k);
                System.out.println(ans1);
                System.out.println(ans2);
                System.out.println("出错了！");
                break;
            }
        }
        System.out.println("测试结束");
    }

    private static boolean sameAnswer(List<List<Integer>> ans1, List<List<Integer>> ans2) {
        if (ans1.size() != ans2.size()) {
            return false;
        }

        for (int i = 0; i < ans1.size(); i++) {
            List<Integer> cur1 = ans1.get(i);
            List<Integer> cur2 = ans2.get(i);

            if (cur1.size() != cur2.size()) {
                return false;
            }

            cur1.sort(((o1, o2) -> o1 - o2));
            cur2.sort(((o1, o2) -> o1 - o2));

            for (int i1 = 0; i1 < cur1.size(); i1++) {
                if (!cur1.get(i1).equals(cur2.get(i1))) {
                    return false;
                }
            }
        }
        return true;
    }


}
