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
}

func repalce(a int, b int) (a1 int, b1 int) {
	return b, a
}
