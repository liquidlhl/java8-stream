package com.edu.practice;

import com.edu.entity.Trader;
import com.edu.entity.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * practice
 *
 * @author:
 * @create: 2019-12-17
 **/
public class TestTransaction {
    List<Transaction> transactions;

    @Before
    public void before() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

    }

    @Test
    public void test() {

//1.找出2011年发生的所有交易,并按交易额排序(从低到高)
        Stream<Transaction> sorted = transactions.stream()
                .filter(e -> e.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue));
        sorted.forEach(System.out::println);
        System.out.println("---------");

//2.交易员都在哪些不同的城市工作过?
        Stream<String> distinct = transactions.stream().map(t -> t.getTrader().getCity()).distinct();
        distinct.forEach(System.out::println);
        System.out.println("---------");

//3,查找所有来自剑桥的交易员,并按姓名排序
        Stream<Trader> cambridge = transactions.stream()
                .filter(e -> e.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getTrader)
                .distinct()
                .sorted((e1, e2) -> (e1.getName().compareTo(e2.getName())));
        cambridge.forEach(System.out::println);
        System.out.println("---------");

//4,返回所有交易员的姓名字符串,按字母顺序排序
        Stream<String> sorted1 = transactions.stream().map(t -> t.getTrader().getName()).sorted();
        sorted1.forEach(System.out::println);
        String collect = transactions.stream()
                .map(t -> t.getTrader().getName())
                .sorted()
                .collect(Collectors.joining());
        System.out.println("collect = " + collect);

        System.out.println("---------");

//5.有没有交易员是在米兰工作的?
        boolean milan = transactions.stream().anyMatch(e -> e.getTrader().getCity().equals("Milan"));
        System.out.println("milan = " + milan);
        System.out.println("---------");

//6.打印生活在剑桥的交易员的所有交易额
        Integer sum = transactions.stream()
                .filter(e -> e.getTrader().getCity().equals("Cambridge"))
                .collect(Collectors.summingInt(Transaction::getValue));
        System.out.println("sum = " + sum);
        System.out.println("---------");
//7.所有交易中,最高的交易额是多少
        Optional<Transaction> max = transactions.stream().max(Comparator.comparing(Transaction::getValue));
        System.out.println("max = " + max.get());
        OptionalInt max1 = transactions.stream().mapToInt(Transaction::getValue).max();
        System.out.println("max1 = " + max1.getAsInt());
        System.out.println("---------");
//8.找到交易额最小的交易
        Optional<Transaction> min = transactions.stream().min(Comparator.comparing(Transaction::getValue));
        System.out.println("min = " + min);


    }

}
