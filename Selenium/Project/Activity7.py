from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Firefox()
driver.get("https://alchemy.hguy.co/lms")
driver.find_element(By.XPATH, "//a[contains(text(),'All Courses')]").click()
elements = driver.find_elements(By.CLASS_NAME, "col-sm-8")
count = len(elements)

print("Number of courses:", count)

driver.quit()