class Node(object):
    def __init__(self, key, data=None):
        self.key = key
        self.data = data
        self.children = {}
class Trie(object):
    def __init__(self):
        self.head = Node(None)

    def insert(self, str):
        pNode = self.head

        for c in str:
            if c not in pNode.children:
                pNode.children[c] = Node(c)

            pNode = pNode.children[c]
        pNode.data = str

    def search(self, str):
        pNode = self.head

        for c in str:
            if c in pNode.children:
                pNode = pNode.children[c]
            else:
                return False
        if pNode.data != None:
            return True

    def starts_with(self, prefix):
        pNode = self.head
        result = []
        subtrie = None

        for c in prefix:
            if c in pNode.children:
                pNode = pNode.children[c]
                subtrie = pNode
            else:
                return False
        q = list(subtrie.children.values())

        while q:
            curr = q.pop()
            if curr.data != None:
                result.append(curr.data)
            q += list(curr.children.values())

        return result
trie = Trie()
trie.insert('abc')
trie.insert('abd')
trie.insert('abdd')
print(trie.starts_with('ab'))