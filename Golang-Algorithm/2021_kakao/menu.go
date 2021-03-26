package main

import (
	"bytes"
	"fmt"
	"sort"
	"strings"
)

var foodMaps [11]map[string]int
var maxCounts [11]int

func main() {
	//orders := []string{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}
	//orders := []string{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}
	orders := []string{"XYZ", "XWY", "WXA"}
	course := []int{2, 3, 4}

	for _, order := range orders {
		var buf bytes.Buffer
		traversal(0, &order, &buf)
	}

	result := make([]string, 0)
	for _, size := range course {
		for k, v := range foodMaps[size] {
			if maxCounts[size] == v && v >= 2 {
				result = append(result, k)
			}
		}
	}
	sort.Strings(result)
	fmt.Println(result)
}

func traversal(index int, menus *string, buf *bytes.Buffer) {
	if index == len(*menus) {
		result := buf.String()
		arr := make([]string, 0)
		for _, char := range result {
			arr = append(arr, string(char))
		}
		sort.Strings(arr)
		result = strings.Join(arr, "")
		size := len(result)
		if size >= 2 {
			if foodMaps[size] == nil {
				foodMaps[size] = make(map[string]int)
			}
			foodMaps[size][result]++
			if foodMaps[size][result] > maxCounts[size] {
				maxCounts[size] = foodMaps[size][result]
			}
		}
		return
	}
	buf.WriteByte((*menus)[index])
	traversal(index+1, menus, buf)
	buf.Truncate(buf.Len() - 1)
	traversal(index+1, menus, buf)
}
