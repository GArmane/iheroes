# iHeroes API

## Description

iHeroes Threat Reporting API.

## Overview

This project is comprised of the following languages and libraries:

* Language: [Python 3.8+](https://www.python.org/)
* Package management: [Poetry](https://python-poetry.org/)
* Web framework: [FastAPI](https://fastapi.tiangolo.com/)
* Production web server: [Uvicorn](http://www.uvicorn.org/)
* Relational database: [Postgres](https://www.postgresql.org/)
* Relational database async support: [databases](https://www.encode.io/databases/)
* Relational database migrations: [Alembic](https://alembic.sqlalchemy.org/en/latest/)
* Relational ORM: [SQLAlchemy](https://www.sqlalchemy.org/)
* Functional programming utilities: [Toolz](https://toolz.readthedocs.io/en/latest/)
* Password hashing utilities: [Passlib](https://passlib.readthedocs.io/)
* Data parsing and validation: [Pydantic](https://pydantic-docs.helpmanual.io/)
* Test Runner: [Pytest](https://docs.pytest.org/en/latest/)
* Linter: [Flake8](https://flake8.pycqa.org/en/latest/)
* Static type checker: [Mypy](https://mypy.readthedocs.io/en/stable/index.html)
* Formatter: [Black](https://github.com/psf/black)

Auxiliary libraries were omitted but can be found in the [pyproject](https://github.com/GArmane/iheroes/tree/master/api/pyproject.toml) file.

## Development

To start development it is recommended to have these utilities installed in a local development machine:

* [Python 3.8+](https://www.python.org/)
* [Docker](https://www.docker.com/)
* [Git](https://git-scm.com/)
* [Plis](https://github.com/IcaliaLabs/plis)

For better development experience, it is recommended these tools:

* [Visual Studio Code](https://code.visualstudio.com/)
* [Poetry](https://python-poetry.org/)

Be certain that you are installing Poetry with the correct version of Python in your machine, that is, Python 3.

This project is already configured with VS Code IDE in mind. To have access of tools and code analysis utilities, you only need to install the project dependencies locally with `poetry install` and to open the project workspace file on VS Code.

The IDE should be automatically configured with standard rules and options for optimal development experience.

### Running the API

To run the API in development mode, follow these steps:

* Start a container with: `plis start --service-ports api ash`
* Run migrations with: `alembic upgrade head`
* Seed DB data with: `poetry run seeder`
* Start the web server with: `poetry run web_server`
* Test the API with: `pytest`
* Check code style with: `black --check iheroes_api`
* Format code with: `black iheroes_api tests`
* Lint the code with: `flake8 iheroes_api tests`
* Run static analysis with: `mypy iheroes_api tests`
* Run entire validation stack with: `black iheroes_api tests && flake8 iheroes_api tests && mypy iheroes_api tests && pytest`

### PGAdmin

A configured instance of PGAdmin for database monitoring and management is provided by default.

To start it, run: `plis start pgadmin`

### Linting, static check and code style guide

Flake8 is the tool of choice for linting. It is configured to warn about code problems, complexity problems, common bugs and to help developers write better code.

Mypy is the tool of choice for static type checking. This project adopts gradual typing as the metodology for code typing. The rules of Mypy will be updated periodically to ensure that the entire code base is typed and consistent.

Black is the tool of choice for formating and code style guide. Black is an uncompromising formatter for Python code, that is, no code style discussions are necessary, the tool is always correct.

Linter and static type checking rules can be discussed and reviewed with the entire team. Any merge request that tries to change these rules without consent is automatically rejected and closed.
