package main

import (
	"fmt"
	"strconv"
)

func main() {
	var c1 byte = 'a'
	fmt.Println(c1)
	fmt.Printf("%c", c1)
	fmt.Println()

	var c2 byte = '6'
	fmt.Println(c2)
	fmt.Printf("%c", c2)
	fmt.Println()

	var c3 byte = '('
	fmt.Println(c3)
	fmt.Printf("%c", c3)
	fmt.Println()

	var c4 int = '中'
	fmt.Println(c4)
	fmt.Printf("%c", c4)
	fmt.Println()

	//只能是单引号的字符
	//var c5 int = "中"
	//fmt.Println(c5)
	fmt.Println("--------------------------------------------------")

	fmt.Println(fmt.Sprintf("%d", 20))
	sprintf := fmt.Sprintf("%v", 20.123456789)
	fmt.Printf("%T", sprintf)
	fmt.Println()
	fmt.Println(sprintf)

	fmt.Println("--------------------------------------------------")

	var age1 = 12
	age2 := 123
	fmt.Printf("%T", age1)
	fmt.Println()
	fmt.Printf("%T", age2)
	fmt.Println()
	fmt.Printf("%T", 123)
	fmt.Println()
	fmt.Println(strconv.FormatInt(123, 10))
	fmt.Println(strconv.FormatInt(int64(age1), 10))
	fmt.Println(strconv.FormatInt(int64(age2), 10))
	fmt.Println(strconv.FormatFloat(123.123, 'f', 6, 64))

	fmt.Println("--------------------------------------------------")

	a, _ := strconv.ParseInt("123", 10, 16)
	fmt.Printf("%T:::", a)
	fmt.Println(a)

	b, _ := strconv.ParseFloat("123.123", 64)
	fmt.Printf("%T:::", b)
	fmt.Println(b)

	c, _ := strconv.ParseFloat("abcdefg", 64)
	fmt.Printf("%T:::", c)
	fmt.Println(c)

}
