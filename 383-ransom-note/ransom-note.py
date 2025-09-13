class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        char_count = {}
        for c in magazine:
            char_count[c] = char_count.get(c,0) + 1

        for c in ransomNote:
            if char_count.get(c,0) == 0:
                return False
            char_count[c] -= 1
        return True