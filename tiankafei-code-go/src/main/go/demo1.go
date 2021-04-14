package main

import (
	list2 "container/list"
	"fmt"
)

var n11 = "你好"
var n12 = 22

var (
	n13        = "你好你好"
	n14        = 15.3
	n15        = false
	n16        = true
	n17 string = "123465"
)

func main() {
	fmt.Println(123465)
	fmt.Println("hello world!")
	fmt.Println("hello goLand!")

	var age = 18
	fmt.Println(age)

	var name = "123"
	fmt.Println(name)

	age = 19
	fmt.Println(age)

	var value = 12.56
	fmt.Println(value)

	var list = list2.New()
	fmt.Println(list.Len())

	aaa := "aaa"
	fmt.Println(aaa)

	var n1, n2, n3 = 10, "你好", 12.3
	fmt.Println(n1, n2, n3)

	n4, n5 := 12, "我们"
	fmt.Println(n4, n5)

	fmt.Println(n11, n12)
	fmt.Println(n13, n14)
	fmt.Println(n15, n16, n17)

}
