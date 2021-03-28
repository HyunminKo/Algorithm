package main

import "fmt"

func main() {
	numbers := []int{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
	fmt.Println(combination(0, 0, 0, &numbers))
}

func combination(count, index, value int, numbers *[]int) int {
	if count == 2 {
		return value
	}
	if index == len(*numbers) {
		return -1
	}
	result := combination(count+1, index+1, value+(*numbers)[index], numbers)
	result2 := combination(count, index+1, value, numbers)
	if result > result2 {
		return result
	} else {
		return result2
	}
}
