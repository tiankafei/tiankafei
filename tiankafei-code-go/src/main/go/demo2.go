package main

import (
	"fmt"
	"unsafe"
)

func main() {

	var num1 int8 = -128
	fmt.Println(num1)
	fmt.Println(num1 - 1)
	fmt.Printf("num1对应的数据类型是：%T", num1)
	fmt.Println()
	fmt.Println("num1占用的字节是：", unsafe.Sizeof(num1))

	fmt.Println("------------------------------")

	var num2 int8 = 127
	fmt.Println(num2)
	fmt.Println(num2 + 1)
	fmt.Printf("num2对应的数据类型是：%T", num2)
	fmt.Println()
	fmt.Println("num2占用的字节是：", unsafe.Sizeof(num2))

	fmt.Println("------------------------------")
	fmt.Println(1 << 7)

	var num = 18
	fmt.Printf("num对应的数据类型是：%T", num)
	fmt.Println()
	fmt.Println("num占用的字节是：", unsafe.Sizeof(num))

	var age1 uint8 = 120
	fmt.Println(age1)

	var age2 byte = 120
	fmt.Println(age2)

	fmt.Println(1.01 + 1.02)

}
