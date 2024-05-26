function generateNumbers() {
    const number1 = Math.floor(Math.random() * 100) + 1;
    const number2 = Math.floor(Math.random() * 100) + 1;
    return { number1, number2 };
}

function verifySolution(data) {
    try {
        const number1 = data.number1;
        const number2 = data.number2;
        const correctProduct = number1 * number2;
        const correctSum = number1 + number2;
        return data.product === correctProduct && data.sum === correctSum;
    } catch (e) {
        return false;
    }
}
