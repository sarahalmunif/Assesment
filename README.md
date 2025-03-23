Q1: Problem solving 

  stack = []
    
    for char in s:
        if char == ')':
            temp = []
            while stack and stack[-1] != '(':
                temp.append(stack.pop())  # Collect substring
            stack.pop()  # Remove '('
            
            # Push back with parentheses
            stack.append('(' + ''.join(temp) + ')')
        else:
            stack.append(char)

  Pros:

Efficient Character Processing (O(n))
Handles Nested Parentheses Correctly

Q2: Database query

SELECT 
    td.user_id,
    u.username,
    td.training_id,
    td.training_date,
    COUNT(*) AS count
FROM training_details td
JOIN user u ON td.user_id = u.user_id
GROUP BY td.user_id, td.training_id, td.training_date
HAVING COUNT(*) > 1
ORDER BY td.training_date DESC


Cons: 
Performance Issues on Large Datasets

If the training_details table is very large, counting occurrences (COUNT(*)) for each user-training combination could slow down execution.
Solution: Adding an index on (user_id, training_id, training_date) can optimize performance.

Benefits of Indexing

✅ Faster Queries – Quickly finds user_id and training_id.
✅ Less CPU Usage – Reduces full table scans.
✅ Speeds Up GROUP BY – Index helps group data more efficiently.



Drawbacks of Indexing

❌ Takes Extra Storage – The index requires additional space.
❌ Slower INSERT & UPDATE – Indexes must be updated whenever data changes.
❌ Overhead for Small Tables – If the table is very small, an index may not be needed.
