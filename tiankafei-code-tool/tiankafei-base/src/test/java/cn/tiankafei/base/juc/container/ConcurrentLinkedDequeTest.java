package cn.tiankafei.base.juc.container;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class ConcurrentLinkedDequeTest {

    public static void main(String[] args) {
        /**
         * 构造方法
         * ConcurrentLinkedDeque():
         *                构造一个空的德克。
         * ConcurrentLinkedDeque(Collection<? extends E> c):
         *               构造最初包含给定集合的元素的deque，以集合的迭代器的遍历顺序添加。
         */

        /**
         * 	1、add(E e):在此deque的尾部插入指定的元素。
         *
         * 	2、iterator()：以正确的顺序返回此deque中的元素的迭代器。
         */
        ConcurrentLinkedDeque<Integer> concurrentLinkedDeque = new ConcurrentLinkedDeque<>();
        Boolean addBoolean = concurrentLinkedDeque.add(5);
        System.out.println("是否插入deque尾部成功？" + addBoolean);

        Iterator<Integer> iterator = concurrentLinkedDeque.iterator();
        while (iterator.hasNext()){
            System.out.println("iterator的结果：" + iterator.next());
        }


        /**
         * 3、addFirst(E e):在此deque前面插入指定的元素。
         */
        ConcurrentLinkedDeque<Integer> concurrentLinkedDeque1 = new ConcurrentLinkedDeque<>();
        concurrentLinkedDeque1.addFirst(1);
        concurrentLinkedDeque1.addFirst(2);
        concurrentLinkedDeque1.addFirst(3);

        Iterator<Integer> iterator1 = concurrentLinkedDeque1.iterator();
        while (iterator1.hasNext()){
            System.out.println("iterator的结果：" + iterator1.next());
        }

        /**
         * 4、addLast(E e):在此deque的末尾插入指定的元素。
         */
        ConcurrentLinkedDeque<Integer> concurrentLinkedDeque2 = new ConcurrentLinkedDeque<>();
        concurrentLinkedDeque2.addLast(7);
        concurrentLinkedDeque2.addLast(8);
        concurrentLinkedDeque2.addLast(9);

        System.out.println("=================");
        Iterator<Integer> iterator2 = concurrentLinkedDeque2.iterator();
        while (iterator2.hasNext()){
            System.out.println("iterator的结果：" + iterator2.next());
        }

        /**
         * 5、contains(Object o)：返回 true如果这个deque包含至少一个元素 e ，返回值为Boolean。
         */
        ConcurrentLinkedDeque<Integer> concurrentLinkedDeque3 = new ConcurrentLinkedDeque<>();
        concurrentLinkedDeque3.add(7);
        concurrentLinkedDeque3.add(8);
        concurrentLinkedDeque3.add(9);
        Boolean containsBoolean = concurrentLinkedDeque3.contains(8);
        System.out.println("concurrentLinkedDeque3是否包含8: " + containsBoolean);

        /**
         * 6、getFirst()：检索，但不删除，这个deque的第一个元素。
         */
        ConcurrentLinkedDeque<Integer> concurrentLinkedDeque4 = new ConcurrentLinkedDeque<>();
        concurrentLinkedDeque4.add(1);
        concurrentLinkedDeque4.add(2);
        concurrentLinkedDeque4.add(3);
        Integer getFirstResult = concurrentLinkedDeque4.getFirst();
        System.out.println("deque的第一个元素：" + getFirstResult);

        /**
         * 7、getLast():检索，但不删除，这个deque的最后一个元素。
         */
        ConcurrentLinkedDeque<Integer> concurrentLinkedDeque5 = new ConcurrentLinkedDeque<>();
        concurrentLinkedDeque5.add(4);
        concurrentLinkedDeque5.add(5);
        concurrentLinkedDeque5.add(6);
        Integer getLast = concurrentLinkedDeque5.getLast();
        System.out.println("deque的最后一个元素：" + getLast);

        /**
         * 8、isEmpty()：如果此集合不包含元素，则返回 true 。
         */
        ConcurrentLinkedDeque<Integer> concurrentLinkedDeque6 = new ConcurrentLinkedDeque<>();
        concurrentLinkedDeque6.add(7);
        concurrentLinkedDeque6.add(8);
        concurrentLinkedDeque6.add(9);
        Boolean isEmptyBoolean = concurrentLinkedDeque5.isEmpty();
        System.out.println("deque是否为空：" + isEmptyBoolean);

        /**
         * 9、offer(E e):在此deque的尾部插入指定的元素,返回值为Boolean。
         */
        ConcurrentLinkedDeque<Integer> concurrentLinkedDeque7 = new ConcurrentLinkedDeque<>();
        concurrentLinkedDeque7.offer(7);
        concurrentLinkedDeque7.offer(8);
        concurrentLinkedDeque7.offer(9);
        System.out.println("=================");
        Iterator<Integer> iterator3 = concurrentLinkedDeque7.iterator();
        while (iterator3.hasNext()){
            System.out.println("iterator的结果：" + iterator3.next());
        }

        /**
         * 10、offerFirst(E e):在此deque前面插入指定的元素,返回值为Boolean。
         */
        ConcurrentLinkedDeque<Integer> concurrentLinkedDeque8 = new ConcurrentLinkedDeque<>();
        concurrentLinkedDeque8.offerFirst(7);
        concurrentLinkedDeque8.offerFirst(8);
        concurrentLinkedDeque8.offerFirst(9);
        System.out.println("=================");
        Iterator<Integer> iterator4 = concurrentLinkedDeque8.iterator();
        while (iterator4.hasNext()){
            System.out.println("iterator的结果：" + iterator4.next());
        }

        /**
         * 11、offerLast(E e):在此deque的末尾插入指定的元素,返回值为Boolean。
         */
        ConcurrentLinkedDeque<Integer> concurrentLinkedDeque9 = new ConcurrentLinkedDeque<>();
        concurrentLinkedDeque9.offerLast(7);
        concurrentLinkedDeque9.offerLast(8);
        concurrentLinkedDeque9.offerLast(9);
        System.out.println("=================");
        Iterator<Integer> iterator5 = concurrentLinkedDeque9.iterator();
        while (iterator5.hasNext()){
            System.out.println("iterator的结果：" + iterator5.next());
        }

        /**
         * 12、peek():检索但不删除由此deque表示的队列的头（换句话说，该deque的第一个元素），
         *            如果此deque为空，则返回 null 。
         */
        ConcurrentLinkedDeque<Integer> concurrentLinkedDeque10 = new ConcurrentLinkedDeque<>();
        concurrentLinkedDeque10.offer(7);
        concurrentLinkedDeque10.offer(8);
        concurrentLinkedDeque10.offer(9);
        System.out.println("队列的头: " + concurrentLinkedDeque10.peek());

        /**
         * 13、peekFirst():检索但不删除此deque的第一个元素，如果此deque为空，则返回 null 。
         */
        ConcurrentLinkedDeque<Integer> concurrentLinkedDeque11 = new ConcurrentLinkedDeque<>();
        concurrentLinkedDeque11.offer(4);
        concurrentLinkedDeque11.offer(5);
        concurrentLinkedDeque11.offer(6);
        System.out.println("队列的头: " + concurrentLinkedDeque11.peekFirst());

        /**
         * 14、peekLast():检索但不删除此deque的最后一个元素，如果此deque为空，则返回 null
         */
        ConcurrentLinkedDeque<Integer> concurrentLinkedDeque12 = new ConcurrentLinkedDeque<>();
        concurrentLinkedDeque12.offer(1);
        concurrentLinkedDeque12.offer(2);
        concurrentLinkedDeque12.offer(3);
        System.out.println("队列的最后一个元素: " + concurrentLinkedDeque12.peekLast());

        /**
         * 15、	poll():检索并删除由此deque表示的队列的头部（换句话说，该deque的第一个元素），
         *            如果此deque为空，则返回 null 。
         */
        ConcurrentLinkedDeque<Integer> concurrentLinkedDeque13 = new ConcurrentLinkedDeque<>();
        concurrentLinkedDeque13.addFirst(1);
        concurrentLinkedDeque13.addFirst(2);
        concurrentLinkedDeque13.addFirst(3);
        Integer addFirstResult = concurrentLinkedDeque13.poll();
        System.out.println("addFirstResult: " + addFirstResult);
        System.out.println("concurrentLinkedDeque13是否还包含3？" + concurrentLinkedDeque13.contains(3));

        /**
         * 16、pollFirst():检索并删除此deque的第一个元素，如果此deque为空，则返回 null 。
         */
        ConcurrentLinkedDeque<Integer> concurrentLinkedDeque14 = new ConcurrentLinkedDeque<>();
        concurrentLinkedDeque14.addFirst(4);
        concurrentLinkedDeque14.addFirst(5);
        concurrentLinkedDeque14.addFirst(6);
        Integer pollFirstResult = concurrentLinkedDeque14.pollFirst();
        System.out.println("pollFirstResult: " + pollFirstResult);
        System.out.println("concurrentLinkedDeque14是否还包含6？" + concurrentLinkedDeque14.contains(6));

        /**
         * 17、pollLast():检索并删除此deque的最后一个元素，如果此deque为空，则返回 null 。
         */
        ConcurrentLinkedDeque<Integer> concurrentLinkedDeque15 = new ConcurrentLinkedDeque<>();
        concurrentLinkedDeque15.addFirst(7);
        concurrentLinkedDeque15.addFirst(8);
        concurrentLinkedDeque15.addFirst(9);
        Integer pollLast = concurrentLinkedDeque15.pollLast();
        System.out.println("pollLast: " + pollLast);
        System.out.println("concurrentLinkedDeque15是否还包含7？" + concurrentLinkedDeque15.contains(7));

        /**
         * 18、pop():从这个deque表示的堆栈中弹出一个元素。
         */
        ConcurrentLinkedDeque<Integer> concurrentLinkedDeque16 = new ConcurrentLinkedDeque<>();
        concurrentLinkedDeque16.addLast(7);
        concurrentLinkedDeque16.addLast(8);
        concurrentLinkedDeque16.addLast(9);
        Integer popResult = concurrentLinkedDeque16.pop();
        System.out.println("popResult: " + popResult);
        System.out.println("concurrentLinkedDeque16是否还包含7？" + concurrentLinkedDeque16.contains(7));

        /**
         * 19、push(E e):将元素推送到由此deque代表的堆栈（换句话说，在该deque的头部），
         *               如果可以立即执行，而不违反容量限制，
         *               则抛出 IllegalStateException如果当前没有可用空间）。
         */
        ConcurrentLinkedDeque<Integer> concurrentLinkedDeque17 = new ConcurrentLinkedDeque<>();
        concurrentLinkedDeque17.push(7);
        concurrentLinkedDeque17.push(8);
        concurrentLinkedDeque17.push(9);
        System.out.println("=================");
        Iterator<Integer> iterator6 = concurrentLinkedDeque17.iterator();
        while (iterator6.hasNext()){
            System.out.println("iterator的结果：" + iterator6.next());
        }

        /**
         * 20、remove():检索并删除由此deque表示的队列的头（换句话说，该deque的第一个元素）。
         */
        ConcurrentLinkedDeque<Integer> concurrentLinkedDeque18 = new ConcurrentLinkedDeque<>();
        concurrentLinkedDeque18.push(1);
        concurrentLinkedDeque18.push(2);
        concurrentLinkedDeque18.push(3);
        Integer removeResult = concurrentLinkedDeque18.remove();
        System.out.println("removeResult: " + removeResult);
        System.out.println("concurrentLinkedDeque18是否还包含3？" + concurrentLinkedDeque18.contains(3));

        /**
         * 21、remove(Object o):删除第一个元素 e ，如果这样一个元素存在于这个deque,返回值为Boolean。
         */
        ConcurrentLinkedDeque<Integer> concurrentLinkedDeque19 = new ConcurrentLinkedDeque<>();
        concurrentLinkedDeque19.push(4);
        concurrentLinkedDeque19.push(5);
        concurrentLinkedDeque19.push(6);
        Boolean removeBoolean = concurrentLinkedDeque19.remove(5);
        System.out.println("是否移除5成功？" + removeBoolean);
        System.out.println("concurrentLinkedDeque19是否还包含3？" + concurrentLinkedDeque19.contains(5));


        /**
         * 22、removeFirst():检索并删除此deque的第一个元素。
         */
        ConcurrentLinkedDeque<Integer> concurrentLinkedDeque20 = new ConcurrentLinkedDeque<>();
        concurrentLinkedDeque20.push(7);
        concurrentLinkedDeque20.push(8);
        concurrentLinkedDeque20.push(9);
        Integer removeFirstResult = concurrentLinkedDeque20.removeFirst();
        System.out.println("deque的第一个元素: " + removeFirstResult);

        /**
         * 23、removeLast():检索并删除此deque的最后一个元素。
         */
        ConcurrentLinkedDeque<Integer> concurrentLinkedDeque21 = new ConcurrentLinkedDeque<>();
        concurrentLinkedDeque21.push(10);
        concurrentLinkedDeque21.push(11);
        concurrentLinkedDeque21.push(12);
        Integer removeLastResult = concurrentLinkedDeque21.removeLast();
        System.out.println("deque的最后一个元素: " + removeLastResult);

        /**
         * 24、size()：返回此deque中的元素数。
         */
        Integer size = concurrentLinkedDeque21.size();
        System.out.println("concurrentLinkedDeque21的元素个数为：" + size);
    }

}
