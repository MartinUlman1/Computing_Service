# Computing Service Application

Tato aplikace je služba, která provádí několik transformací na zadaných číslech. Poskytuje REST API pro manipulaci s čísly a vrácení výsledku po aplikaci několika kroků na číslo.

## Funkce aplikace

Aplikace implementuje několik kroků pro zpracování čísla:

1. **Shiftování číslic**: Posune číslice, které jsou menší nebo rovné 3, o jednu pozici doprava.
2. **Násobení číslic 8 a 9**: Číslice `8` a `9` jsou vynásobeny dvěma.
3. **Odstranění číslice 7**: Všechny číslice `7` jsou odstraněny.
4. **Vydělení počtem sudých číslic**: Výsledek je vydělen počtem sudých číslic ve výsledném čísle.

### Příklad:

Pokud zadáš číslo `789`, provede se následující:

1. **Shiftování číslic**:
   - Číslice `7` zůstane na místě.
   - Číslice `8` a `9` se posunou doprava.

2. **Násobení číslic 8 a 9**:
   - Číslice `8` bude vynásobena 2, stane se `16`.
   - Číslice `9` bude vynásobena 2, stane se `18`.

3. **Odstranění číslice 7**:
   - Číslice `7` je odstraněna.

4. **Výsledek**:
   - Výsledek bude `809`.

## Instalace

Pokud chceš spustit tuto aplikaci lokálně, postupuj následovně:

### 1. Klonuj tento repozitář:
```bash
git clone https://github.com/your-username/computing-service.git

### 2. Přejdi do adresáře projektu:

cd computing-service

### 3. Použij Maven nebo Gradle pro sestavení projektu:

mvn clean install

gradle build

### 4. Spusť aplikaci:

mvn spring-boot:run

gradle bootRun

POUŽITÍ
Po spuštění aplikace budeš moci využívat REST API. Pro interakci s API můžeš použít nástroje jako Postman nebo cURL.

Endpointy:

GET /api/calculate/{number}:
Vstup: number (long) – číslo, které bude zpracováno.
Výstup: Výsledek zpracování podle popsaných pravidel.

Příklad požadavku:

GET http://localhost:8080/api/calculate/789
