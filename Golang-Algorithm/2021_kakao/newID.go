package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
	"unicode"
)

func main() {
	reader := bufio.NewReader(os.Stdin)
	input, _ := reader.ReadString('\n')
	input = input[:len(input)-1]

	var answer string
	// 1 step
	lower := strings.ToLower(input)
	fmt.Println("1 step:", lower)

	// 2 step
	for _, char := range lower {
		pass := func(c rune) bool {
			if unicode.IsDigit(c) || unicode.IsLetter(c) {
				return true
			}
			if c == '-' || c == '_' || c == '.' {
				return true
			}
			return false
		}
		if pass(char) {
			answer += string(char)
		}
	}
	fmt.Println("2 step:", answer)

	// 3 step
	answer = strings.ReplaceAll(answer, "..", ".")
	fmt.Println("3 step:", answer)

	// 4 step
	for {
		if len(answer) == 0 {
			break
		}
		start := answer[0]
		if start == '.' {
			answer = answer[1:]
		} else {
			break
		}
	}
	for {
		if len(answer) == 0 {
			break
		}
		end := answer[len(answer)-1]
		if end == '.' {
			answer = answer[:len(answer)-1]
		} else {
			break
		}
	}
	fmt.Println("4 step:", answer)

	// 5 step
	if answer == "" {
		answer = "a"
	}
	fmt.Println("5 step:", answer)

	// 6 step
	if len(answer) >= 16 {
		answer = answer[:15]
		end := answer[len(answer)-1]
		if end == '.' {
			answer = answer[:len(answer)-1]
		}
	}
	fmt.Println("6 step:", answer)

	// 7 step
	if len(answer) <= 2 {
		for len(answer) < 3 {
			answer += string(answer[len(answer)-1])
		}
	}
	fmt.Println("7 step:", answer)
}
