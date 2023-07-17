from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Firefox()
driver.get("https://alchemy.hguy.co/lms")
driver.find_element(By.XPATH, "//a[contains(text(),'My Account')]").click()
assert driver.title == "My Account – Alchemy LMS"
driver.find_element(By.XPATH, "//a[contains(text(),'Login')]").click()
driver.find_element(By.XPATH, "//p[@class='login-username']/input").send_keys("root")
driver.find_element(By.ID, "user_pass").send_keys("pa$$w0rd")
driver.find_element(By.ID, ("wp-submit")).click()
assert driver.find_element(By.XPATH, ("//a[contains(text(),'Logout')]")).is_displayed()
driver.find_element(By.XPATH, ("//a[contains(text(),'Logout')]")).click()
driver.quit()
