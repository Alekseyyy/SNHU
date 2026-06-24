
# submitter.py
# this was written to solve the "Are you fast enough?" challenge

# By Aleksey
#  - github.com/Alekseyyy
#  - medium.com/@EpsilonCalculus

import time
from selenium.webdriver import Firefox
from selenium.webdriver.firefox.options import Options
from selenium.webdriver.common.keys import Keys

# Configure the browser
options = Options()
options.set_headless()
assert options.headless
my_browser = Firefox(options=options)
my_browser.get("http://timesink.be/speedy/index.php")

# Get the random string
the_key = my_browser.find_element_by_id("rndstring")
the_key = the_key.text

# Submit the random string
submission = my_browser.find_element_by_id("inputfield")
submission.send_keys(the_key)
submission.send_keys(Keys.ENTER)
time.sleep(0.5)

# Display the flag
src = my_browser.page_source
flag = src[src.find("{") + 1 : src.find("}")]
print("brixelCTF{" + flag + "}")
