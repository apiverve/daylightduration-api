from setuptools import setup, find_packages

setup(
    name='apiverve_daylightdurationcalculator',
    version='1.1.12',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Daylight Duration Calculator computes sunrise, sunset times, and total daylight hours for any geographic location and date using astronomical algorithms.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
