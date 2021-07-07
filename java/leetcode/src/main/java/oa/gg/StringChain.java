package oa.gg;
/**
 * 给一个 list of string, find max length of a chain.
Chain的要求是，每个string相当于前一个string在最后加一个character，比如 {ab, abc, abcd}是一个valid chain
楼主给了两个solution，一个是先按length sort，用hashmap，存以当前string结尾的chain的length，one pass就可以
另一个solution是prefix tree
follow up是如果list很长，怎么处理。
partition，相当于prefix tree的子树存在不同的machine上（有hot point 再分），
因为无法排序，每次insert要对新插入的string的子树做dfs，follow up没写code
leetcode 1048 longest string chain
 */
public class StringChain {
    
}
