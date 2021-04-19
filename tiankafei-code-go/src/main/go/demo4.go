package main

import (
	"fmt"
)

func main() {
	var age1 = 18
	fmt.Println(age1)
	fmt.Println(&age1)

	var age2 *int = &age1
	fmt.Println(age2)
	fmt.Println(*age2)
	fmt.Println(&age2)

	*age2 = 20
	fmt.Println(age1)

	var a = 1
	var b = 0
	fmt.Println(a, b)
	a, b = repalce(a, b)
	fmt.Println(a, b)

	var age3 int32 = 123
	fmt.Printf("%T", 132)
	fmt.Println()
	fmt.Printf("%T", age3)
	fmt.Println()

	var age4 int64 = 123
	var agr5 int = 123
	fmt.Println(int(age4) + agr5)

	var i int8 = 0
	var sum = 0
	for ; i < 6; i++ {
		sum += int(i)
	}
	fmt.Println(sum)
	fmt.Println("-----------")
	//元组交换位置
	a, b = 1, 2
	fmt.Println(a, b)
	b, a = a, b
	fmt.Println(a, b)

	//for  {
	//	fmt.Println("-----------")
	//}
	fmt.Println("-----------")
	var str = "你好你好abcd"
	for i, value := range str {
		var s1 = fmt.Sprintf("%d", i)
		var s2 = fmt.Sprintf("%c", value)
		fmt.Println(s1, s2)
	}
}

func repalce(a int, b int) (a1 int, b1 int) {
	return b, a
}
