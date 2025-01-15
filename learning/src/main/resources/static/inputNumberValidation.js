document.querySelectorAll('input[type="number"]').forEach(InputNumber => {
    InputNumber.oninput = () => {
        if (InputNumber.value.length > InputNumber.maxLength) {
            InputNumber.value = InputNumber.value.slice(0, InputNumber.maxLength);
        }
    };
});
