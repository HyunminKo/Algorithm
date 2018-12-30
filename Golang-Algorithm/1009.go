package main

import "fmt"

func findComNum(rn []int, a, b int) ([]int, int) {
	rn = append(rn, a%10)
	var i int
	temp := a
	for i = 1; rn[0] != (temp*a)%10 && i < b; i++ {
		temp = (temp * a) % 10
		rn = append(rn, temp)
	}
	return rn, i
}
func main() {
	var N int
	fmt.Scanf("%d", &N)
	for i := 0; i < N; i++ {
		var a, b int
		rotateNumbers := make([]int, 0)
		fmt.Scanf("%d %d", &a, &b)
		rotateNumbers, index := findComNum(rotateNumbers, a, b)
		if a%10 == 0 {
			fmt.Printf("%d\n", 10)
		} else {
			if b%index == 0 {
				fmt.Printf("%d\n", rotateNumbers[index-1])
			} else {
				fmt.Printf("%d\n", rotateNumbers[(b%index)-1])
			}
		}
	}
}
