const calculateResult = (jsonInput) => {
  const data = JSON.parse(jsonInput);
  const number1 = data.number1;
  const number2 = data.number2;

    //write code here the result is stored in a variable called result
  

  return JSON.stringify({ result: result });
};

// Assuming the JSON string is passed as the first argument
const jsonInput = process.argv[2];
const output = calculateResult(jsonInput);
console.log(output);
