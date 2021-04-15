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
}

func repalce(a int, b int) (a1 int, b1 int) {
	return b, a
}
