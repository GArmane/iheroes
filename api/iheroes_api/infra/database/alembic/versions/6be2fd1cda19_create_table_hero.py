"""Create table hero.

Revision ID: 6be2fd1cda19
Revises: f5249f11268b
Create Date: 2020-07-10 23:14:59.672608

"""
import sqlalchemy as sa
from alembic import op
from sqlalchemy.dialects import postgresql

# revision identifiers, used by Alembic.
revision = "6be2fd1cda19"
down_revision = "f5249f11268b"
branch_labels = None
depends_on = None


def upgrade():
    op.create_table(
        "hero",
        sa.Column("id", sa.Integer(), nullable=False),
        sa.Column("user_id", sa.Integer(), nullable=False),
        sa.Column(
            "name", sa.String(length=100), server_default="Unknown", nullable=False
        ),
        sa.Column("nickname", sa.String(length=100), nullable=False),
        sa.Column(
            "power_class",
            postgresql.ENUM("S", "A", "B", "C", name="power_class"),
            nullable=False,
        ),
        sa.Column("location", sa.JSON(), nullable=False),
        sa.CheckConstraint(
            "length(name) >= 1 AND length(name) <= 100",
            name=op.f("ck_hero_name_length"),
        ),
        sa.CheckConstraint(
            "length(nickname) >= 1 AND length(nickname) <= 100",
            name=op.f("ck_hero_nickname_length"),
        ),
        sa.ForeignKeyConstraint(
            ["user_id"], ["user.id"], name=op.f("fk_hero_user_id_user")
        ),
        sa.PrimaryKeyConstraint("id", name=op.f("pk_hero")),
        sa.UniqueConstraint("name", "nickname", name=op.f("uq_hero_name_nickname")),
    )


def downgrade():
    op.drop_table("hero")
    sa.Enum(name="power_class").drop(op.get_bind(), checkfirst=False)
