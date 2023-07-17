from selenium import webdriver
from selenium.webdriver.common.by import By
import time

driver = webdriver.Firefox()
driver.get("https://alchemy.hguy.co/lms")
driver.find_element(By.XPATH, "//a[contains(text(),'My Account')]").click()
driver.find_element(By.XPATH, "//a[contains(text(),'Login')]").click()
driver.find_element(By.XPATH, "//p[@class='login-username']/input").send_keys("root")
driver.find_element(By.ID, "user_pass").send_keys("pa$$w0rd")
driver.find_element(By.ID, "wp-submit").click()
time.sleep(3)
driver.find_element(By.XPATH, "//a[contains(text(),'All Courses')]").click()
driver.find_element(By.XPATH, "//h3[contains(text(),'Email Marketing Strategies')]/following-sibling::p[2]/a[@href='https://alchemy.hguy.co/lms/courses/email-marketing-strategies/']").click()
driver.find_element(By.XPATH, "//div[@id='ld-item-list-71']/div[1]/div/a/div[1]").click()
assert driver.title == "Deliverability Of Your Emails – Alchemy LMS"
if driver.find_element(By.CLASS_NAME, "ld-status").text != "COMPLETE":
    driver.quit()
else:
    print("Already completed")
    driver.quit()