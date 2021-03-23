package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

func main() {
	reader := bufio.NewReader(os.Stdin)
	input, _ := reader.ReadString('\n')
	input = input[:len(input)-1]

	// 1 step
	lower := strings.ToLower(input)
	fmt.Println("1 step:", lower)

	// 2 step
	validChar := map[int32]bool{
		'-': true,
		'_': true,
		'.': true,
	}
	var validStrings []string
	for _, char := range lower {
		pass := func(c int32) bool {
			result := false
			if c >= 48 && c <= 57 {
				result = true
			} else if c >= 97 && c <= 122 {
				result = true
			} else if c >= 65 && c <= 90 {
				result = true
			} else if _, ok := validChar[c]; ok {
				result = true
			}
			return result
		}
		if pass(char) {
			validStrings = append(validStrings, string(char))
		}
	}
	validStr := strings.Join(validStrings, "")
	fmt.Println("2 step:", validStr)

	// 3 step
	replaceStr := strings.ReplaceAll(validStr, "..", ".")
	fmt.Println("3 step:", replaceStr)

	// 4 step
	for {
		if len(replaceStr) == 0 {
			break
		}
		start := replaceStr[0]
		if start == '.' {
			replaceStr = replaceStr[1:]
		} else {
			break
		}
	}
	for {
		if len(replaceStr) == 0 {
			break
		}
		end := replaceStr[len(replaceStr)-1]
		if end == '.' {
			replaceStr = replaceStr[:len(replaceStr)-1]
		} else {
			break
		}
	}
	fmt.Println("4 step:", replaceStr)

	// 5 step
	if replaceStr == "" {
		replaceStr = "a"
	}
	fmt.Println("5 step:", replaceStr)

	// 6 step
	if len(replaceStr) >= 16 {
		replaceStr = replaceStr[:15]
		end := replaceStr[len(replaceStr)-1]
		if end == '.' {
			replaceStr = replaceStr[:len(replaceStr)-1]
		}
	}
	fmt.Println("6 step:", replaceStr)

	// 7 step
	if len(replaceStr) <= 2 {
		for len(replaceStr) < 3 {
			replaceStr += string(replaceStr[len(replaceStr)-1])
		}
	}
	fmt.Println("7 step:", replaceStr)
}
