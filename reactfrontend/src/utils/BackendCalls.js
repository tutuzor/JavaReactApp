export const getAllAccounts = async () => {
    const response = await fetch('/api/get_all_accounts');
    const result = await response.json();
    return result;
}

export const getAllTransactions = async () => {
    const response = await fetch('/api/get_all_transactions');
    const result = await response.json();
    return result;
}

export const addAccount = async (newAccount) => {
    await fetch(
        'api/add', {
            method: 'POST',
            headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
            }, 
            body: JSON.stringify(newAccount)
        }
    );
}

export const getAllCustomers = async () => {
    const response = await fetch('/api/get_all_customers');
    const result = await response.json();
    return result;
}