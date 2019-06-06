class Node(object):
    def __init__(self, key, value=None):
        self.key = key
        self.value = value
        self.children = {}


class Trie(object):
    def __init__(self):
        self.root = Node(None)

    def add(self, strValue):
        pointerNode = self.root

        for c in strValue:
            if c not in pointerNode.children:
                pointerNode.children[c] = Node(c)
            pointerNode = pointerNode.children[c]
        pointerNode.value = strValue

    def find(self, strValue):
        pointerNode = self.root

        for c in strValue:
            if c in pointerNode.children:
                pointerNode = pointerNode.children[c]
            else:
                return False
        if pointerNode.value != None:
            return True

    def findPrefixes(self, prefix):
        pointerNode = self.root
        result = []
        subtrie = None

        for c in prefix:
            if c in pointerNode.children:
                pointerNode = pointerNode.children[c]
                subtrie = pointerNode
            else:
                return 0
        q = list(subtrie.children.values())

        while q:
            current = q.pop(0)
            if current.value != None:
                result.append(current.value)
            q += list(current.children.values())
        return len(result) - 1

names = ['steve','stevens','danny','steves','dan','john','johnny','joe','alexm','alexander']
query = ['steve','alex','joe','john','dan']
def findCompletePrefixes(names, query):
    trie = Trie()
    for name in names:
        trie.add(name)
    result = []
    for q in query:
        result.append(trie.findPrefixes(q))
    return result

print(findCompletePrefixes(['joe'],['joe']))