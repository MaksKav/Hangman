# **Гра "Шибениця"**

## Правила гри

###### Мета:

Гравець повинен вгадати приховане слово, вводячи по одній літері за раз. Якщо гравець вгадує букву правильно, вона відкривається у слові. Якщо вгадування неправильне, малюється частина шибениці. Мета — вгадати слово, перш ніж шибениця буде повністю намальована.

###### Ігровий процес:

Додаток випадковим чином обирає слово зі списку.
Слово замінюється на підкреслення _, що представляє кількість літер у слові.
Гравець вводить літеру:
Якщо літера є у слові, вона відкривається на правильних позиціях.
Немає різниці, в якому регістрі буде написана літера.
Якщо літери немає у слові, лічильник помилок збільшується, і частина шибениці малюється.
Гравцеві дозволено певну кількість помилок (зазвичай 6).

###### Кінець гри:

Гра закінчується, коли гравець або вгадує всі літери у слові (перемога), або лічильник помилок досягає максимуму (поразка).
Після закінчення гри відображається результат та приховане слово.

###### Повторна гра:

Після закінчення гри гравець може вибрати почати нову гру або вийти з додатку.

### **Функціональність додатку та меню консольного інтерфейсу:**
1. На початку додаток пропонує варіанти почати нову гру або вийти з додатку.
2. При початку нової гри випадковим чином обирається слово, і гравець розпочинає процес його вгадування.
3. Після введення кожної літери в консолі відображається кількість помилок та поточний стан шибениці (намальований за допомогою ASCII-символів).
4. Наприкінці гри відображається результат (перемога чи поразка), і користувач повертається до початкового стану, де йому пропонується вибір: почати нову гру або вийти з додатку.