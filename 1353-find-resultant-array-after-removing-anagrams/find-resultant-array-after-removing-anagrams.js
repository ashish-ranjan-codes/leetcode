/**
 * @param {string[]} words
 * @return {string[]}
 */
var removeAnagrams = function(words) {
    const result = [words[0]];
    for(let i=1; i<words.length; i++){
        const isAnagram = (a,b) => 
            a.length === b.length && a.split('').sort().join('') === b.split('').sort().join('');
        if(!isAnagram(words[i], result[result.length-1])){
            result.push(words[i]);
        }
    }
    return result;
};