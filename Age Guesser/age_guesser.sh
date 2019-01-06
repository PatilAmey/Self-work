#!bin/bash
intersted_func()
{
echo "Question 1: Choose one number from 1 2 3 4 5 6 7 8 9"
read number
result=$((number*2+5))
result=$((result*50))
echo "Question 2: If you have celebrated your birthday this year enter: Y else this joyful event is about the happen then enter: N"
read choice
if [[ $choice == Y || $choice == y ]]; then
result=$((result+1768))
elif [[ $choice == N || $choice == n ]]; then
result=$((result+1767))
else
echo "Enter correct choice"
fi
echo "We are doing good so far....!"
echo "Question 3: Enter your birth year"
read birth_year
result=$((result-$birth_year))
echo "Your Age is:"
echo $result | tail -c 3 
echo "The number you choose was:" 
echo $result | head -c 1
echo 
}
echo "Welcome to Age Guesser. I will guess your age just answer the asked questions...!"
echo "Ready"
echo "Press Y/N"
read interested
if [[ $interested == Y || $interested == y ]]; then
echo "Great to see your interested... Here we GO.....!!"
intersted_func
elif [[ $interested == N || $interested == n ]]; then
echo "Okay see you next time....."
else
echo "Enter correct choice"
fi