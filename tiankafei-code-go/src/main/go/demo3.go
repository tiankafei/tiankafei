package main

import "fmt"

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

}
