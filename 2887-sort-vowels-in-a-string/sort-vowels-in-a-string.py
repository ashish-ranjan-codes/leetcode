class Solution:
    def sortVowels(self, s: str) -> str:
        vowels = "aeiouAEIOU"
        vowel_chars = [c for c in s if c in vowels]
        vowel_chars.sort()
        s_list = list(s)
        index = 0

        for i in range(len(s_list)):
            if s_list[i] in vowels:
                s_list[i] = vowel_chars[index]
                index += 1

        return "".join(s_list)