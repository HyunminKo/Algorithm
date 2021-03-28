package main

import "fmt"

func main() {
	numbers := []int{1, 2, 3, 4}
	fmt.Println(permutation(0, 0, 0, &numbers))
}

func permutation(count, used, value int, numbers *[]int) int {
	if count == 2 {
		return value
	}

	result := 0
	for i := 0; i < len(*numbers); i++ {
		if (used & (1 << i)) != 0 {
			continue
		}
		temp := permutation(count+1, used|(1<<i), value*10+(*numbers)[i], numbers)
		if temp > result {
			result = temp
		}
	}
	return result
}
